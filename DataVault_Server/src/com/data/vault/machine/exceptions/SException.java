package com.data.vault.machine.exceptions;
public class SException extends Exception
{
public SException(String message)
{
    super(message);
    System.out.println("Server Exception: "+message);
}
}