package team1065.robot.frc2017.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import team1065.robot.frc2017.commands.ManualCameraControl;

/**
 *
 */
public class CameraSystem extends Subsystem {
	UsbCamera camera0;
	UsbCamera camera1;
	
	public CameraSystem(){
		camera0 = new UsbCamera("cam0",0);
		camera0.setFPS(15);
		camera0.setResolution(320, 240);
		
		camera1 = new UsbCamera("cam1",1);
		camera1.setFPS(15);
		camera1.setResolution(320, 240);
		
		CameraServer.getInstance().startAutomaticCapture(camera0);
		CameraServer.getInstance().startAutomaticCapture(camera1);
		
		//TODO: investigate camera switching with new system
	}
    public void initDefaultCommand() {
        setDefaultCommand(new ManualCameraControl());
    }
}

