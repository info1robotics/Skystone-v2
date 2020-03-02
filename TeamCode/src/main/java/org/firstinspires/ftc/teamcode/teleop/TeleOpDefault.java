package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.teleop.actions.ArmsAction;
import org.firstinspires.ftc.teamcode.teleop.actions.ArmsAction;
import org.firstinspires.ftc.teamcode.teleop.actions.IntakeAction;
import org.firstinspires.ftc.teamcode.teleop.actions.MoveRobotAction;
import org.firstinspires.ftc.teamcode.vision.DetectedObject;

import java.util.ArrayList;

@TeleOp(name = "TeleOp Default", group = "Default")
public class TeleOpDefault extends TeleOpBase {

    @Override
    public void entry() {

//        new ChangeSpeedAction(this, true);
//        new FoundationHookAction(this);
        new MoveRobotAction.MoveRobotMobilityDriver(this);
        new MoveRobotAction.MoveRobotArmsDriver(this, true);
        new IntakeAction(this);
        new ArmsAction.ArmsElevation(this);
        new ArmsAction.ArmsMacaraAndPickup(this, true);
        new ArmsAction.ArmsFoundationHooks(this);

    }

    @Override
    public void runLoop() {
//        TelemetryPacket packet = new TelemetryPacket();
//
//        ArrayList<DetectedObject> detectedObjects = webcamVision.getAllDetections();
//        for(int i = 0; i < detectedObjects.size(); i++) {
//            packet.put(Integer.toString(i), detectedObjects.get(i));
//        }
//
//        dashboard.sendTelemetryPacket(packet);
    }
}
