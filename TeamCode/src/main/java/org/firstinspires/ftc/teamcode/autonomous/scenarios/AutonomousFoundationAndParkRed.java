package org.firstinspires.ftc.teamcode.autonomous.scenarios;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;

import roadrunner.drive.mecanum.SampleMecanumDriveBase;
import roadrunner.drive.mecanum.SampleMecanumDriveREV;

import static org.firstinspires.ftc.teamcode.AppConstants.intakeMotors.INTAKE_SPEED;

@Autonomous(name = "Autonomous Foundation and Park Red", group = "match")
public class AutonomousFoundationAndParkRed extends AutonomousBase {
    @Override
    public void runCommands() throws InterruptedException {
////        autonomousController.followTrajectorySync(
////                autonomousController.trajectoryBuilder()
////                .forward(10)
////                .build()
////        );
////        autonomousController.turnSync(Math.toRadians(-45));
//        armController.releaseFoundation();
//        intakeController.runIn(INTAKE_SPEED);
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .strafeTo(new Vector2d(70, 0))
//                .build()
//        );
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .back(40)
//                .build()
//        );
//        intakeController.stopAll();
//        autonomousController.turnSync(Math.toRadians(205));
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .strafeLeft(105)
//                .build()
//        );
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .back(23)
//                .build()
//        );
//        armController.grabFoundation();
//        Thread.sleep(700);
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .splineTo(new Pose2d(0, -50, Math.toRadians(90)))
//                .build()
//        );
//        armController.releaseFoundation();
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .back(50)
//                .build()
//        );
//
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                        .forward(40)
//                        .build()
//        );
////
////        autonomousController.followTrajectory(
////                autonomousController.trajectoryBuilder()
////                        .strafeTo(new Vector2d(25, -20))
////                        .build()
////        );

        armController.releaseFoundation();
        autonomousController.followTrajectorySync(
                autonomousController.trajectoryBuilder()
                .forward(5)
                .build()
        );
        autonomousController.turnSync(Math.toRadians(180));
        autonomousController.followTrajectorySync(
                autonomousController.trajectoryBuilder()
                .strafeTo(new Vector2d(32, -15))
                .build()
        );
        armController.grabFoundation();
        Thread.sleep(700);
        autonomousController.followTrajectorySync(
                autonomousController.trajectoryBuilder()
                .forward(47)
                .build()
        );
        armController.releaseFoundation();
        autonomousController.followTrajectorySync(
                autonomousController.trajectoryBuilder()
                .strafeRight(60)
                .build()
        );
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .splineTo(new Pose2d(5, 0, Math.toRadians(90)))
//                .build()
//        );
//        armController.releaseFoundation();
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .back(20)
//                .build()
//        );
//        autonomousController.followTrajectorySync(
//                autonomousController.trajectoryBuilder()
//                .strafeTo(new Vector2d(0, 25))
//                .build()
//        );
    }
}
