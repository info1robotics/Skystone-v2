package roadrunner.drive.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import roadrunner.drive.mecanum.SampleMecanumDriveBase;
import roadrunner.drive.mecanum.SampleMecanumDriveREV;

/*
 * This is a simple routine to test translational drive capabilities.
 */
@Config
@Autonomous(group = "drive")
public class jnql extends LinearOpMode {
    public static double DISTANCE = 48;

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDriveBase drive = new SampleMecanumDriveREV(hardwareMap);


        waitForStart();

        if (isStopRequested()) return;


        Trajectory trajectoryF = drive.trajectoryBuilder()
                .forward(DISTANCE)
                .build();


        Trajectory trajectoryB = drive.trajectoryBuilder()
                .back(DISTANCE)
                .build();

        int i = 0;
        while(opModeIsActive() && i < 10) {
            drive.followTrajectorySync(trajectoryF);
            Thread.sleep(200);
            drive.followTrajectorySync(trajectoryB);
            i++;
            Thread.sleep(200);
        }

    }
}
