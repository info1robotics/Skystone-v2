package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

@Autonomous(name = "AUTONOMIE SUPREMA DE PARCARE", group = "Rosu")
public class AutonomousRedBuildingZone extends AutonomousBase {
    public void runCommands() throws InterruptedException {
        autonomousController.followTrajectorySync(
                autonomousController.trajectoryBuilder()
                .forward(20.0)
                .build()
        );
        movementController.stopAll();
    }
}
