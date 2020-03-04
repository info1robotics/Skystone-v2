package roadrunner.autonomousController.opmode;

import android.util.Log;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.arm.ArmsController;

import org.firstinspires.ftc.teamcode.autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.vision.DetectedObject;
import org.firstinspires.ftc.teamcode.vision.ObjectCodes;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;

import java.util.ArrayList;

@Config
@Autonomous(group = "auto")
public class AutonomousTestgrounds extends AutonomousBase {


    @Override
    public void runOpMode() throws IllegalCaseException {


        WebcamVision webcamVision = new WebcamVision(hardwareMap, telemetry);
        ArmsController armsController = new ArmsController(hardwareMap, telemetry, this);
        ArrayList<DetectedObject> detectedObjects = new ArrayList<>();

        while(!isStarted()) {
            detectedObjects = webcamVision.getAllDetections();
        }

        if (isStopRequested()) return;


        int case_no = -1;
        int no = 1;
        for(DetectedObject i : detectedObjects) {
            if(i.objectCode == ObjectCodes.SKYSTONE)
                case_no = no;
            no++;
        }

        switch(case_no) {
            case 3: {

                break;
            }
            case 2: {
                break;
            }
            case 1: {
                break;
            }
            default: {
//                throw new IllegalCaseException("No skystones detected!");
                roadController.followTrajectorySync(
                        roadController.trajectoryBuilder()
                                .splineTo(new Pose2d(27.5, -3, Math.toRadians(93)))
                                .build()
                );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                roadController.followTrajectorySync(
                        roadController.trajectoryBuilder()
                        .strafeTo(new Vector2d(20, -70))
                        .build()
                );
                roadController.turnSync(Math.toRadians(87));
                roadController.followTrajectorySync(
                        roadController.trajectoryBuilder()
                        .back(16.0)
                        .build()
                );
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                armsController.grabFoundation();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                roadController.followTrajectorySync(
                        roadController.trajectoryBuilder()
                        .splineTo(new Pose2d(20, -15, Math.toRadians(90)))
                        .build()
                );
                roadController.followTrajectorySync(
                        roadController.trajectoryBuilder()
                        .back(35)
                        .build()
                );

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                roadController.followTrajectory(
                        roadController.trajectoryBuilder()
                        .forward(30)
                        .build()
                );
//                roadController.followTrajectorySync(
//                        roadController.trajectoryBuilder()
//                                .strafeRight(12)
//                                .build()
//                );
//                roadController.turnSync(Math.toRadians(90));
//                roadController.followTrajectorySync(
//                        roadController.trajectoryBuilder()
//                            .splineTo(new Pose2d(15, -50, Math.toRadians(90)))
//                        .build()
//                );
//                roadController.followTrajectorySync(
//                        roadController.trajectoryBuilder()
//                                .strafeLeft(12)
//                                .build()
//                );
//                roadController.turnSync(Math.toRadians(8));
//
//                roadController.followTrajectorySync(
//                        roadController.trajectoryBuilder()
//                                .forward(120)
//                                .build()
//                );

            }
        }


        Log.w("AutonomousTestGrounds", "CASE NO.: " + case_no);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void runCommands() throws InterruptedException {

    }
}

class IllegalCaseException extends RuntimeException {
    public IllegalCaseException(String errorMessage) {
        super(errorMessage);
    }
}
