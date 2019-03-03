package org.usfirst.frc.team1212.robot.commands;

import org.usfirst.frc.team1212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class ExtendHerdersCom extends TimedCommand{

    public ExtendHerdersCom() {
        this(0);
        
        setTimeout(2);
        requires(Robot.herderSub);

    }
    
    public ExtendHerdersCom(int x) {
    	super(2);
    }

    @Override
    protected void initialize() {
    	
    	Robot.herderSub.ExtendHerders();
    }

    @Override
    protected void execute() {
    	
    	Robot.herderSub.ExtendHerders();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    	
    }

  
    @Override
    protected void interrupted() {
    	end();
    }

}
