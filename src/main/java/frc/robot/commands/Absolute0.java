package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ElevAngSub;
import frc.robot.subsystems.ElevadorSub;
import frc.robot.subsystems.ManipuladorSub;
import frc.robot.subsystems.ManipuloSub;
import frc.robot.Constants;

public class Absolute0 extends SequentialCommandGroup{

    public Absolute0(ElevadorSub elev, ElevAngSub elevang, ManipuloSub ManipuloSub, ManipuladorSub manipulador){
    
        addCommands(
            new ParallelCommandGroup(
                new ElevadorCMD(elev, Constants.Elev_Default),
                new ManipuloRotCMD(ManipuloSub, Constants.Rot0),
                new ManipuladorDispCMD(manipulador, 0)
            ),
            new ParallelCommandGroup(
                new ElevAngCMD(elevang, Constants.Ang_Default),
                new Inclinacao(ManipuloSub, Constants.Inc_Default)
            )
            
        );
}
}
