package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED;

/*
 * This sample demonstrates how to stream frames from Vuforia to the dashboard. Make sure to fill in
 * your Vuforia key below and select the 'Camera' preset on top right of the dashboard. This sample
 * also works for UVCs with slight adjustments.
 */

public class AutonomousVisionDebug extends AutonomousBase {

    @Override
    public void runCommands() throws InterruptedException {
        movementController.moveRightAutonomous(MOVEMENT_SPEED, 18.0);
        movementController.moveBackwardAutonomous(MOVEMENT_SPEED, 42.0);
        while(opModeIsActive()) {
            //visionController.getDetection();
        }
    }
}
