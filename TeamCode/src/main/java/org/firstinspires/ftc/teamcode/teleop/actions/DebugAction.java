package org.firstinspires.ftc.teamcode.teleop.actions;

import org.firstinspires.ftc.teamcode.AppConstants;
import org.firstinspires.ftc.teamcode.teleop.TeleOpBase;

public class DebugAction extends TeleOpAction {
    public DebugAction(TeleOpBase opMode) {
        super(opMode);
    }

    @Override
    public void run() {
        if(gamepad1.right_trigger > 0.0) {
            double spin = gamepad1.right_trigger;


            double currentSpeed = AppConstants.robotMovement.MOVEMENT_SPEED;

            spin *= currentSpeed;
            movementController.moveTeleOp(0, 0, spin);
        }
        else movementController.stopAll();
    }

    @Override
    void onThreadDestruction() {

    }
}
