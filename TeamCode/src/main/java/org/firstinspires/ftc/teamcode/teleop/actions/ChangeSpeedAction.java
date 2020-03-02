package org.firstinspires.ftc.teamcode.teleop.actions;

import org.firstinspires.ftc.teamcode.AppConstants;
import org.firstinspires.ftc.teamcode.teleop.TeleOpBase;

import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED_FAST;
import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED_SLOW;

public class ChangeSpeedAction extends TeleOpAction {
    public ChangeSpeedAction(TeleOpBase opMode) {
        super(opMode);
    }

    @Override
    public void run() {
        if(gamepad1.x)
            AppConstants.robotMovement.MOVEMENT_SPEED = MOVEMENT_SPEED_SLOW;
        if(gamepad1.b)
            AppConstants.robotMovement.MOVEMENT_SPEED = MOVEMENT_SPEED_FAST;
    }

    @Override
    void onThreadDestruction() {

    }
}
