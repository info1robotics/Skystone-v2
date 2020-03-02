package org.firstinspires.ftc.teamcode.teleop.actions;//package org.firstinspires.ftc.teamcode.teleop.actions;

import org.firstinspires.ftc.teamcode.teleop.TeleOpBase;

public class ArmsAction {

    public static class ArmsElevation extends TeleOpAction {
        public ArmsElevation(TeleOpBase opMode) {
            super(opMode);
        }

        @Override
        public void run() {
            if(gamepad2.left_trigger > 0)
                armsController.arm1Up(gamepad2.left_trigger);
            else if(gamepad2.right_trigger > 0)
                armsController.arm1Down(gamepad2.right_trigger);
            else armsController.stopDc();
        }

        @Override
        void onThreadDestruction() {

        }
    }

    public static class ArmsMacaraAndPickup extends TeleOpAction {

        static boolean macaraExtended = false;
        public ArmsMacaraAndPickup(TeleOpBase opMode, boolean useThread) {
            super(opMode);
        }

        @Override
        public void run() {

            if(gamepad2.right_bumper || gamepad1.right_bumper) {
                if(macaraExtended)
                    armsController.retractMacara();
                else armsController.extendMacara();
                macaraExtended = !macaraExtended;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(gamepad2.x || gamepad1.left_bumper) {
                armsController.servoCarligToggle();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        @Override
        void onThreadDestruction() {

        }
    }


    public static class ArmsFoundationHooks extends TeleOpAction {
        static boolean foundationHooked = false;

        public ArmsFoundationHooks(TeleOpBase opMode) {
            super(opMode);
        }

        @Override
        public void run() {
            if(gamepad1.x) {
                if(foundationHooked)
                    armsController.releaseFoundation();
                else armsController.grabFoundation();
                foundationHooked = !foundationHooked;

                try {
                    Thread.sleep((long)500.0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        void onThreadDestruction() {

        }
    }
}
