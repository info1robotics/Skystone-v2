package org.firstinspires.ftc.teamcode.vision;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebcamVision {


    Telemetry console;

    private static final String VUFORIA_LICENSE_KEY = "AcTB3h7/////AAABma7je7SvYkkqrJT5rzDrtvh/dZ4kzPKDHWZs" +
            "kG12sOplNFyVylw2VzUahIt1kP22rq+oYVqkn+++JewM0W0NXk7KDbcMo0cQAtI8WcgJjYh+jTmoNuokUg2A" +
            "NIpNyrqpKBR9VU5tjQEb5akUNBkyfJiKLXWfxv79vaTGptYiGoK4pn9THnHo2PTWtlE5mpts4NjjdUJJe5u8D" +
            "9g8g0GIaLYDr6qmVuGaZ/ZeM8ZVwIo390U6uc5xJ37SmvZH4DNCALdd+isOsOJ9LYJV5Qvn0kZhO3IAoN0mLk" +
            "fJ2lhqTjHnzba9K8JSTM2LE+fbmdxSsoUj3uEhCWENSqyjZCbLouLfBpRjkVEVor3mhYI+emGF\n";



    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";

    private VuforiaLocalizer vuforia;
    public TFObjectDetector tfod;
    public FtcDashboard dashboard;
    private Telemetry dashboardTelemetry;

    public WebcamVision(HardwareMap hardwareMap, Telemetry console) {
        VuforiaLocalizer.Parameters vuforiaParams = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        vuforiaParams.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
        vuforiaParams.vuforiaLicenseKey = VUFORIA_LICENSE_KEY;
        vuforiaParams.cameraDirection = VuforiaLocalizer.CameraDirection.DEFAULT;
        vuforia = ClassFactory.getInstance().createVuforia(vuforiaParams);


        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, ObjectCodes.STONE.toString(),
                ObjectCodes.SKYSTONE.toString());
        console.addData("TF Object Detection", "Set up");
        if (tfod != null) {
            tfod.activate();
        }

        dashboard = FtcDashboard.getInstance();
        dashboard.startCameraStream(tfod, 0);

        this.console = console;
        dashboardTelemetry = dashboard.getTelemetry();


    }



    public DetectedObject getFrontDetection() {
        if (tfod != null) {
            List<Recognition> recognitions = tfod.getRecognitions();
            if (recognitions == null || recognitions.size() == 0) {
                return new DetectedObject(ObjectCodes.NO_OBJECT, -1, -1);
            }

            Recognition mainObject = null;

            int minDeltaWidth = 10000;
            float xCenter = 0, yCenter = 0;

            for (Recognition r: recognitions) {
                int deltaWidth = (int)Math.abs((r.getImageWidth() / 2) - ((r.getLeft() + r.getRight()) / 2));

                String res = "";
                res += r.getLabel();
                res += ": ";
                res += Integer.toString(deltaWidth);
                console.addLine(res);

                if (minDeltaWidth > deltaWidth) {
                    minDeltaWidth = deltaWidth;
                    mainObject = r;
                    xCenter = (r.getLeft() + r.getRight()) / 2;
                    yCenter = (r.getBottom() + r.getTop()) / 2;
                }


            }

            if (mainObject.getLabel().equals(ObjectCodes.SKYSTONE.toString()))
                return new DetectedObject(ObjectCodes.SKYSTONE, xCenter, yCenter);
            if (mainObject.getLabel().equals(ObjectCodes.STONE.toString()))
                return new DetectedObject(ObjectCodes.STONE, xCenter, yCenter);

        }
        return new DetectedObject(ObjectCodes.NO_OBJECT, -1, -1);
    }

    public ArrayList<DetectedObject> getAllDetections() {
        if (tfod != null) {
            ArrayList<DetectedObject> detectedObjects = new ArrayList<>();
            List<Recognition> recognitions = tfod.getRecognitions();
            if (recognitions == null || recognitions.size() == 0) {
                return new ArrayList<>();
            }

            for (Recognition r: recognitions) {
                detectedObjects.add(
                        new DetectedObject(
                                ObjectCodes.valueOf(r.getLabel()),
                                (r.getLeft() + r.getRight()) / 2,
                                (r.getBottom() + r.getTop()) / 2
                        )
                );

            }

            Collections.sort(detectedObjects, new Comparator<DetectedObject>() {
                @Override
                public int compare(DetectedObject o1, DetectedObject o2) {
                    return (int)(o1.xCenter - o2.xCenter);
                }
            });

            return detectedObjects;
        }

        return new ArrayList<>();
    }

}