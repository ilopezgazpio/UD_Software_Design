package es.deusto.ingenieria.sd.util.observer.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteObservable extends Remote
{
	public void addRemoteObserver(IRemoteObserver observer) throws RemoteException;
	public void deleteRemoteObserver(IRemoteObserver observer) throws RemoteException;
}