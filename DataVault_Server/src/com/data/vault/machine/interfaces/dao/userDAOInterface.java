package com.data.vault.machine.interfaces.dao;
import com.data.vault.machine.exceptions.*;
import com.data.vault.machine.interfaces.dto.*;
import java.util.*;

public interface userDAOInterface
{

public void add(userDTOInterface userDTO) throws SException;

public void delete(int userID) throws SException;

public userDTOInterface getByUserID(int userID) throws SException;

public userDTOInterface getByLoginID(String loginID) throws SException;

public boolean userIDExists(int userID) throws SException;

public boolean loginIDExists(String loginID) throws SException;

public boolean authenticateUser(String loginID,String password) throws SException;

public int getCount() throws SException;

public userDTOInterface[] getFriends(int userID) throws SException;

public boolean isFrndActive(int userID) throws SException;

public String getReceiverIP(int userID) throws SException;

}