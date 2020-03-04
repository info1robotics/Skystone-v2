package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

@Autonomous(name = "Autonomous Foundation and Park Red", group = "match")
public class AutonomousFoundationAndParkRed extends AutonomousBase {
    @Override
    public void runCommands() throws InterruptedException {
////        roadController.followTrajectorySync(
////                roadController.trajectoryBuilder()
////                .forward(10)
////                .build()
////        );
////        roadController.turnSync(Math.toRadians(-45));
//        armController.releaseFoundation();
//        intakeController.runIn(INTAKE_SPEED);
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .strafeTo(new Vector2d(70, 0))
//                .build()
//        );
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .back(40)
//                .build()
//        );
//        intakeController.stopAll();
//        roadController.turnSync(Math.toRadians(205));
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .strafeLeft(105)
//                .build()
//        );
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .back(23)
//                .build()
//        );
//        armController.grabFoundation();
//        Thread.sleep(700);
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .splineTo(new Pose2d(0, -50, Math.toRadians(90)))
//                .build()
//        );
//        armController.releaseFoundation();
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .back(50)
//                .build()
//        );
//
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                        .forward(40)
//                        .build()
//        );
////
////        roadController.followTrajectory(
////                roadController.trajectoryBuilder()
////                        .strafeTo(new Vector2d(25, -20))
////                        .build()
////        );

        armController.releaseFoundation();
        roadController.followTrajectorySync(
                roadController.trajectoryBuilder()
                .forward(5)
                .build()
        );
        roadController.turnSync(Math.toRadians(180));
        roadController.followTrajectorySync(
                roadController.trajectoryBuilder()
                .strafeTo(new Vector2d(32, -15))
                .build()
        );
        armController.grabFoundation();
        Thread.sleep(700);
        roadController.followTrajectorySync(
                roadController.trajectoryBuilder()
                .forward(47)
                .build()
        );
        armController.releaseFoundation();
        roadController.followTrajectorySync(
                roadController.trajectoryBuilder()
                .strafeRight(60)
                .build()
        );
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .splineTo(new Pose2d(5, 0, Math.toRadians(90)))
//                .build()
//        );
//        armController.releaseFoundation();
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .back(20)
//                .build()
//        );
//        roadController.followTrajectorySync(
//                roadController.trajectoryBuilder()
//                .strafeTo(new Vector2d(0, 25))
//                .build()
//        );
    }
}
