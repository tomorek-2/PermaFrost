package JavaCode;
import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.dialogs.SettingsMenuDialog;

public class ModomodrekUI extends Mod {

     static float calculateMinus;
   static float calculateSum;
    static float calculateNumber;
    static float calculateLastResult;
    static float calculatePlus;
    public static void showCalculate(SettingsMenuDialog.SettingsTable Dialog001){

        Dialog001.clear();


        //Dialog001.button("close", ()-> Dialog001.hide()).size(50f, 90f);
        Dialog001.button("-", () -> {
            calculateMinus++;
            calculateSum++;
            calculateLastResult -= calculateNumber;
            calculateNumber = 0;
        });
        Dialog001.button("+", () -> {
            calculatePlus++;
            calculateSum++;
            calculateLastResult += calculateNumber;
            calculateNumber = 0;

        });
        Dialog001.button("*", () -> {
            calculatePlus++;
            calculateSum++;
            calculateLastResult *= calculateNumber;
            calculateNumber = 0;

        });
        Dialog001.button("/", () -> {
            calculatePlus++;
            calculateSum++;
            calculateLastResult /= calculateNumber;
            calculateNumber = 0;
        });
        Dialog001.button("clear", () -> {
            calculatePlus++;
            calculateSum++;
            calculateLastResult = 0;
            calculateNumber = 0;
        });
        Dialog001.top();
        Dialog001.field("Result: " + calculateLastResult, field->{

        }).size(450f, 30f).with(field ->{
            field.setDisabled(false);
            field.update(() -> {
                field.setText("Result: " + calculateLastResult +  " Number: " + calculateNumber);
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


    }
}
