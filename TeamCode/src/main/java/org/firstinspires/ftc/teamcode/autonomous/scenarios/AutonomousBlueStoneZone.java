package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

import static org.firstinspires.ftc.teamcode.AppConstants.intakeMotors.INTAKE_SPEED;
import static org.firstinspires.ftc.teamcode.AppConstants.robotMovement.MOVEMENT_SPEED_SLOW;

@Autonomous(name = "Autonomie Albastru Stone Zone", group = "Albastru")

public class AutonomousBlueStoneZone extends AutonomousBase {
    public void runCommands() {
        intakeController.runIn(INTAKE_SPEED);
        movementController.moveForwardAutonomous(MOVEMENT_SPEED_SLOW, 120.0);
        intakeController.stopAll();
        movementController.moveBackwardAutonomous(MOVEMENT_SPEED_SLOW, 55.0);
        movementController.moveLeftAutonomous(MOVEMENT_SPEED_SLOW, 150.0);
        intakeController.runOut(INTAKE_SPEED);
        movementController.moveRightAutonomous(MOVEMENT_SPEED_SLOW, 200.0);
        intakeController.runIn(INTAKE_SPEED);
        movementController.moveForwardAutonomous(MOVEMENT_SPEED_SLOW, 100.0);
        intakeController.stopAll();
        movementController.moveBackwardAutonomous(MOVEMENT_SPEED_SLOW, 85.0);
        movementController.moveLeftAutonomous(MOVEMENT_SPEED_SLOW, 250.0);
        movementController.moveRightAutonomous(MOVEMENT_SPEED_SLOW, 80.0);
        movementController.stopAll();
    }
}
