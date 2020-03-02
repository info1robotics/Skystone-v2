package org.firstinspires.ftc.teamcode.movement;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MovementMotors {
    private DcMotor fl, fr, bl, br;
    private Telemetry console;

    public MovementMotors(HardwareMap hardwareMap, Telemetry telemetry) {

        console = telemetry;
        try {

            fl = hardwareMap.get(DcMotor.class, "motorFL");
            fr = hardwareMap.get(DcMotor.class, "motorFR");
            bl = hardwareMap.get(DcMotor.class, "motorBL");
            br = hardwareMap.get(DcMotor.class, "motorBR");
            console.addData
                    ("MovementMotors class", "Done with set up.");
        } catch(Exception ex) {
            console.addLine(ex.toString());
            console.update();
        }

    }

    public void setPower(Power power) {
        fl.setPower(power.fl);
        fr.setPower(-1.0 * power.fr);
        bl.setPower(power.bl);
        br.setPower(-1.0 * power.br);
    }

    public void setMode(DcMotor.RunMode runMode) {
        fl.setMode(runMode);
        fr.setMode(runMode);
        bl.setMode(runMode);
        br.setMode(runMode);
    }

    public void setTargetPosition(int position, Power direction) {
        fl.setTargetPosition((int)(direction.fl * position));
        fr.setTargetPosition((int)(-1.0 * direction.fr * position));
        bl.setTargetPosition((int)(direction.bl * position));
        br.setTargetPosition((int)(-1.0 * direction.br * position));
    }

    public boolean isBusy() {
        return fl.isBusy() && fr.isBusy() && bl.isBusy() && br.isBusy();
    }

    public void stopAll() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }

    public String toString() {
        String res = "";
        res += " fl: ";
        res += Double.toString(fl.getPower());
        res += " fr: ";
        res += Double.toString(-1.0 * fr.getPower());
        res += " bl: ";
        res += Double.toString(bl.getPower());
        res += " br: ";
        res += Double.toString(-1.0 * br.getPower());
        return res;
    }


}
