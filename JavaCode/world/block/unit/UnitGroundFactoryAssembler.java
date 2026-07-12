package world.block.unit;

import static mindustry.Vars.net;
import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

import JavaCode.ModomodrekMain;
import arc.math.Mathf;
import arc.math.geom.Point2;
import arc.math.geom.Vec2;
import mindustry.ai.types.AssemblerAI;
import mindustry.entities.Units;
import mindustry.gen.BuildingTetherc;
import mindustry.gen.Call;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.world.blocks.units.UnitAssembler;

public class UnitGroundFactoryAssembler extends UnitAssembler {
    public UnitGroundFactoryAssembler(String name) {
        super(name);

    }
public class UnitGroundFactoryAssemblerBuild extends UnitAssemblerBuild {
@Override
    public void updateTile() {
    super.updateTile();
    if(ModomodrekMain.HeatMap.get(new Point2(tile.x, tile.y), 0) <= 1f) {
return;
    }
    if(!readUnits.isEmpty()){
        units.clear();
        readUnits.each(i -> {
            var unit = Groups.unit.getByID(i);
            if(unit != null){
                units.add(unit);
            }
        });
        readUnits.clear();
    }

    if(lastTier != currentTier){
        if(lastTier >= 0f){
            progress = 0f;
        }

        lastTier =
                lastTier == -2 ? -1 : currentTier;
    }

    //read newly synced drones on client end
    if(units.size < dronesCreated && whenSyncedUnits.size > 0){
        whenSyncedUnits.each(id -> {
            var unit = Groups.unit.getByID(id);
            if(unit != null){
                units.addUnique(unit);
            }
        });
    }

    units.removeAll(u -> !u.isAdded() || u.dead || !(u.controller() instanceof AssemblerAI));

    //unsupported
    if(!allowUpdate()){
        progress = 0f;
        units.each(Unit::kill);
        units.clear();
    }

    float powerStatus = !enabled ? 0f : power == null ? 1f : power.status;
    powerWarmup = Mathf.lerpDelta(powerStatus, powerStatus > 0.0001f ? 1f : 0f, 0.1f);
    droneWarmup = Mathf.lerpDelta(droneWarmup, units.size < dronesCreated ? powerStatus : 0f, 0.1f);
    totalDroneProgress += droneWarmup * delta();

    if(units.size < dronesCreated && enabled && (droneProgress += delta() * state.rules.unitBuildSpeed(team) * powerStatus / droneConstructTime) >= 1f){
        if(!net.client()){
            var unit = droneType.create(team);
            //If a unit isn't using AssemblerAI, it's bugged, likely because of an incorrect data patch or mod.
            //In that case, just ignore it and don't spawn anything
            if(unit.controller() instanceof AssemblerAI){
                if(unit instanceof BuildingTetherc bt){
                    bt.building(this);
                }
                unit.set(x, y);
                unit.rotation = 90f;
                unit.add();
                units.add(unit);
                Call.assemblerDroneSpawned(tile, unit.id);
            }else{
                droneProgress = 0f;
            }
        }
    }

    if(units.size >= dronesCreated){
        droneProgress = 0f;
    }

    Vec2 spawn = getUnitSpawn();

    if(moveInPayload() && !wasOccupied){
        yeetPayload(payload);
        payload = null;
    }

    //arrange units around perimeter
    for(int i = 0; i < units.size; i++){
        var unit = units.get(i);
        var ai = (AssemblerAI)unit.controller();

        ai.targetPos.trns(i * 90f + 45f, areaSize / 2f * Mathf.sqrt2 * tilesize).add(spawn);
        ai.targetAngle = i * 90f + 45f + 180f;
    }

    wasOccupied = checkSolid(spawn, false);
    boolean visualOccupied = checkSolid(spawn, true);
    float eff = (units.count(u -> ((AssemblerAI)u.controller()).inPosition()) / (float)dronesCreated);

    sameTypeWarmup = Mathf.lerpDelta(sameTypeWarmup, wasOccupied && !visualOccupied ? 0f : 1f, 0.1f);
    invalidWarmup = Mathf.lerpDelta(invalidWarmup, visualOccupied ? 1f : 0f, 0.1f);

    var plan = plan();

    //check if all requirements are met
    if(!wasOccupied && efficiency > 0 && Units.canCreate(team, plan.unit)){
        warmup = Mathf.lerpDelta(warmup, efficiency, 0.1f);

        if((progress += edelta() * state.rules.unitBuildSpeed(team) * eff / plan.time) >= 1f){
            Call.assemblerUnitSpawned(tile);
        }
    }else{
        warmup = Mathf.lerpDelta(warmup, 0f, 0.1f);
    }

    }
}
}
