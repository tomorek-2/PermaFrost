package JavaCode;
import arc.Core;
import arc.input.KeyCode;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.dialogs.SettingsMenuDialog;

public class ModomodrekUI extends Mod {

     static float calculateMinus;
   static float calculateSum;
    static float calculateNumber;
    static float calculateLastResult;
    static float calculatePlus;
    static float calculateWIPResult;
    public static void showCalculate(SettingsMenuDialog.SettingsTable Dialog001){

        Dialog001.clear();


        //Dialog001.button("close", ()-> Dialog001.hide()).size(50f, 90f);
        Dialog001.button("-", () -> {

            calculateLastResult -= calculateNumber;
            calculateNumber = 0;
        });
        Dialog001.button("+", () -> {

            calculateLastResult += calculateNumber;
            calculateNumber = 0;

        });
        Dialog001.button("sin", () -> {

            calculateLastResult=arc.math.Mathf.sinDeg(calculateNumber);
            calculateNumber=0;

        });

        Dialog001.button("cos",()->{

            calculateLastResult=arc.math.Mathf.cosDeg(calculateNumber);
            calculateNumber=0;});
        Dialog001.button("%", () -> {

            if(calculateNumber != 0) {
                calculateLastResult %= calculateNumber;
                calculateNumber = 0;
            } else {
                calculateLastResult = 0;
                calculateNumber = 0;
            }
            calculateNumber = 0;

        });
        Dialog001.button("*", () -> {

            if(calculateNumber != 0) {
                calculateLastResult *= calculateNumber;
                calculateNumber = 0;
            } else {
                calculateLastResult = 0;
                calculateNumber = 0;
            }

        });
        Dialog001.button("/", () -> {

            if(calculateNumber != 0) {
                calculateLastResult /= calculateNumber;
                calculateNumber = 0;
            }

        });
        Dialog001.button("^", () -> {

            calculateWIPResult = calculateLastResult;
            if(calculateNumber != 0) {
                calculateLastResult = (float) Math.pow(calculateLastResult, calculateNumber);
                calculateNumber = 0;
            }

        });
        Dialog001.button("clear", () -> {

            calculateLastResult = 0;
            calculateNumber = 0;
        });
        Dialog001.top();
        Dialog001.field("Result: " + calculateLastResult, field->{

        }).size(225f, 30f).with(field ->{
            field.setDisabled(false);
            field.update(() -> {
                field.setText("Result: " + calculateLastResult);
            });
        });
        Dialog001.center();
        for(float i = 0; i <= 9; i++) {
            float finalI = i;
            Dialog001.button("" + i, () -> {
                calculateNumber *= 10;
                calculateNumber += finalI;
            }).bottom();


        }

Dialog001.field("Number",text->{
    calculateNumber = arc.util.Strings.parseFloat(text, 0f);
}).size(175f, 30f).with(field ->{

    field.update(() -> {
        field.setText("" + calculateNumber);

    });
});;
        Dialog001.update(() -> {
            for(int i = 0; i<10; i++) if(arc.Core.input.keyTap(arc.input.KeyCode.valueOf("num"+i))) calculateNumber = calculateNumber * 10 + i;
        if(arc.Core.input.keyTap(arc.input.KeyCode.plus)) { calculateLastResult += calculateNumber; calculateNumber = 0; } if(arc.Core.input.keyTap(arc.input.KeyCode.minus)) { calculateLastResult -= calculateNumber; calculateNumber = 0; } });
    }
}
