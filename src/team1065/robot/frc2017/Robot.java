
package team1065.robot.frc2017;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team1065.robot.frc2017.commands.autonomous.AutoTest;
import team1065.robot.frc2017.subsystems.CameraSystem;
import team1065.robot.frc2017.subsystems.Climber;
import team1065.robot.frc2017.subsystems.DriveTrain;
import team1065.robot.frc2017.subsystems.GearSystem;
import team1065.robot.frc2017.subsystems.Intake;
import team1065.robot.frc2017.subsystems.Shooter;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static Intake intake;
	public static Compressor compressor;
	public static CameraSystem cameras;
	public static GearSystem gearSystem;
	public static Climber climber;
	
	Command autonomousCommand;

    public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		shooter = new Shooter();
		intake = new Intake();
		compressor = new Compressor();
		cameras = new CameraSystem();
		gearSystem = new GearSystem();
		climber = new Climber();
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	driveTrain.resetAngle();
    	driveTrain.resetEncoder();
    	
    	Command[] CommandsArray = {
			new AutoTest(),
			new AutoTest(),
			new AutoTest(),
			new AutoTest(),
		};

    	//Selector 0 == Boiler(gear then shoot), 1 == Center(gear then shoot), 2 == Center(gear then go to neutral), 3 == Hooper (gear the go to neutral)
    	int autoSelector = oi.getAutoKnobPosition();
    	
    	autonomousCommand = CommandsArray[autoSelector];
    	
    	
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	driveTrain.resetAngle();
    	driveTrain.resetEncoder();
    	if (autonomousCommand != null){
    		autonomousCommand.cancel();
    	}
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
