package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED_SLOW;

@Autonomous(name = "ACEASTA AUTONOMIE CU ROBOT MERGAND INTAI SPRE DREAPTA")
public class AutonomousUseThisRight extends AutonomousBase {
    @Override
    public void runCommands() throws InterruptedException {
        movementController.moveRightAutonomous(MOVEMENT_SPEED_SLOW, 85.0);
        movementController.moveForwardAutonomous(MOVEMENT_SPEED_SLOW, 75.0);
        movementController.stopAll();
    }
}
