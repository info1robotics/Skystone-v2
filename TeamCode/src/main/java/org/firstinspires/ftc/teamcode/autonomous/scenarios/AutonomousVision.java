package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED;

/*
 * This sample demonstrates how to stream frames from Vuforia to the dashboard. Make sure to fill in
 * your Vuforia key below and select the 'Camera' preset on top right of the dashboard. This sample
 * also works for UVCs with slight adjustments.
 */
@Autonomous
public class AutonomousVision extends AutonomousBase {

    @Override
    public void runCommands() throws InterruptedException {

        movementController.moveRightAutonomous(MOVEMENT_SPEED, 18.0);
        movementController.moveBackwardAutonomous(MOVEMENT_SPEED, 47.0);

        int skystonesFound = 0;
        boolean canDetectSkystone = true;
        while(skystonesFound < 2) {
           // DetectedObject obj = visionController.getDetection();
            //if(obj.objectCode == ObjectCodes.SKYSTONE && obj.widthDelta < 60) {
                //armController.closeBarrier();
                Thread.sleep(500);
                //armController.openBarrier();
                skystonesFound++;
                canDetectSkystone = false;
                moveStone();
            //} else if(obj.objectCode == ObjectCodes.STONE) {
                canDetectSkystone = true;
            //}
            movementController.moveLeftAutonomous(MOVEMENT_SPEED, 10);
        }
        movementController.stopAll();

    }

    private  void moveStone() {
        movementController.moveBackwardAutonomous(MOVEMENT_SPEED, 80);
        movementController.moveForwardAutonomous(MOVEMENT_SPEED, 80);
    }
}
