package org.firstinspires.ftc.teamcode.vision;

public class DetectedObject {
    public ObjectCodes objectCode;
    public float xCenter;
    public float yCenter;

    public DetectedObject(ObjectCodes objectCode, float xCenter, float yCenter) {
        this.objectCode = objectCode;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public String toString() {
        return objectCode.toString() + " " + xCenter + " " + yCenter;
    }
}