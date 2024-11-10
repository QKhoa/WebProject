package model.daointerface;

import java.util.List;

public interface DAOInterface<T>  {

    public void insert(T obj);

    public void update(T obj);


    public void deleteByID(String id);


    public T findByID(String id);

    public List<T> selectAll();

    public T findByID(int id);


    public T checkAccount(String username , String password);


}
