
package team1065.robot.frc2017;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team1065.robot.frc2017.subsystems.CameraSystem;
import team1065.robot.frc2017.subsystems.DriveTrain;
import team1065.robot.frc2017.subsystems.Intake;
import team1065.robot.frc2017.subsystems.Shooter;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static Intake intake;
	public static Compressor compressor;
	public static CameraSystem cameras;

    public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		shooter = new Shooter();
		intake = new Intake();
		compressor = new Compressor();
		cameras = new CameraSystem();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	driveTrain.resetAngle();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	driveTrain.resetAngle();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.updateStatus();
        shooter.updateStatus();
        
        if(oi.getCompressorOverride()){
        	compressor.setClosedLoopControl(false);
        }
        else{
        	compressor.setClosedLoopControl(true);
        }
        
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
