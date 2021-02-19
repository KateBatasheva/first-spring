package ru.geekbrains.katebatasheva.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Commands {

    ADD(1),DELETE(2),READ_ALL(3),UPDATE(4),AVG(6),AMOUNT(5);

//    List<Commands> commandsList = new ArrayList<>(Arrays.asList(Commands.values()));


    int command;

    Commands(int command) {
        this.command = command;
    }

    public int getCommand() {
        return command;
    }

//    public Commands getByCode (int code){
//        for (int i = 0; i <commandsList.size() ; i++) {
//            if (commandsList.get(i).getCommand() == code){
//                return commandsList.get(i);
//            }
//        }
//       return null;
//    }


}
