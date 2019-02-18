/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

/**
 *
 * @author Polis
 */
public class User {
    private  int points;
    private final String name;
    public User(String name)
    {
        this.name=name;
        this.points=0;
        
    }
    public int getPoints()
    {
        return points;
    }
    public void setPoints(int points){
        this.points=points;
    }
    public String getName()
    {
        return name;
    }
    public void addPoints(int points){
        this.points+=points;
    }
    public void removePoints(int points){
        this.points-=points;
    }
}
