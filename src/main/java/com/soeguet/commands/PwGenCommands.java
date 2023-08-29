package com.soeguet.commands;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@Command
public class PwGenCommands {

    private final char[] allCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+{}[]".toCharArray();

    @Command(command = "gen", description = "Generate a password")
    public String generate(@Option(shortNames = 'l', defaultValue = "15") String length) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < Integer.parseInt(length); i++) {

            stringBuilder.append(allCharacters[(int) (Math.random() * allCharacters.length)]);
        }

        copyStringToSystemClipboard(stringBuilder);

        return stringBuilder.toString() + " (copied to clipboard)";
    }

    private void copyStringToSystemClipboard(StringBuilder stringBuilder) {

        System.setProperty("java.awt.headless", "false");
        Clipboard clipboard = Toolkit.getDefaultToolkit()
                                     .getSystemClipboard();
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        clipboard.setContents(stringSelection, null);
    }
}
