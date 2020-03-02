package roadrunner.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import roadrunner.drive.mecanum.SampleMecanumDriveBase;
import roadrunner.drive.mecanum.SampleMecanumDriveREV;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREV(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        drive.setPoseEstimate(new Pose2d(-33, -63, 90));
        drive.followTrajectorySync(
                drive.trajectoryBuilder()
                        .splineTo(new Pose2d(0, 0, Math.toRadians(90)))
                        .build()
        );


        Thread.sleep(1000);
//
//        drive.turnSync(Math.toRadians(90));

//
//        drive.followTrajectorySync(
//                drive.trajectoryBuilder()
//                        .splineTo(new Pose2d(20, 0, Math.toRadians(0)))
//                        .build()
//        );

//        drive.followTrajectorySync(
//                drive.trajectoryBuilder()
//                        .strafeTo(new Vector2d(20, -80))
//                        .build()
//        );
//
//        Thread.sleep(1000);
//
//        drive.followTrajectorySync(
//                drive.trajectoryBuilder()
//                        .strafeTo(new Vector2d(20, 10))
//                        .build()
//        );
//
////
////        drive.followTrajectorySync(
////                drive.trajectoryBuilder()
////                        .splineTo(new Pose2d(15, -80, Math.toRadians(-90)))
////                        .build()
////        );



    }
}
