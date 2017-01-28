package team1065.robot.frc2017.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1065.robot.frc2017.RobotMap;
import team1065.robot.frc2017.commands.ManualShooterControl;

/**
 *
 */
public class Shooter extends Subsystem {

    CANTalon masterTalon, slaveTalon;
    
    public Shooter(){
    	masterTalon = new CANTalon(RobotMap.MASTER_TALON_PORT);
    	slaveTalon = new CANTalon(RobotMap.SLAVE_TALON_PORT);
    	
    	slaveTalon.changeControlMode(CANTalon.TalonControlMode.Follower);
    	slaveTalon.set(RobotMap.MASTER_TALON_PORT);
    	slaveTalon.enableBrakeMode(false);
    	slaveTalon.clearStickyFaults();
    	slaveTalon.reverseOutput(false);//TODO: verify
    	slaveTalon.setVoltageRampRate(36.0);
    	
    	masterTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	//TODO: using 4*20, check if the rpms are sensible values
    	masterTalon.configEncoderCodesPerRev(80);
    	masterTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	masterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
    	masterTalon.configPeakOutputVoltage(+12.0f, 0.0f);
    	masterTalon.reverseSensor(false);
    	masterTalon.reverseOutput(false);
    	masterTalon.setVoltageRampRate(36.0);
    	masterTalon.enableBrakeMode(false);
    	masterTalon.clearStickyFaults();
    	masterTalon.setProfile(0);
    	masterTalon.setF(RobotMap.SHOOTER_F);
    	masterTalon.setP(RobotMap.SHOOTER_P);
    	masterTalon.setI(RobotMap.SHOOTER_I); 
        masterTalon.setD(RobotMap.SHOOTER_D);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ManualShooterControl());
    }
    
    public void setRpm(double rpm) {
    	masterTalon.changeControlMode(CANTalon.TalonControlMode.Speed);
        masterTalon.set(rpm);
    }

    public void setOpenLoop(double speed) {
    	masterTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	masterTalon.set(speed);
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Shooter Talon Speed", masterTalon.getSpeed());
    	SmartDashboard.putNumber("Shooter Talon get", masterTalon.get());
    	SmartDashboard.putNumber("Shooter Setpoint", masterTalon.getSetpoint());
    }
}

