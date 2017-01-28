
package team1065.robot.frc2017;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team1065.robot.frc2017.subsystems.DriveTrain;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;

    public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.updateStatus();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
