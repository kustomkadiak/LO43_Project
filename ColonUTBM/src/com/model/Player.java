package com.model;

import java.awt.Color;
import java.util.ArrayList;

import com.model.card.*;
import com.model.port.*;
import com.observer.*;

public class Player implements Observable{

/********************** Attributes **********************/
	private ArrayList<Observer> observers;
	
	private String name;
	
	private Color color;
	
	private int passageOrder;
	
	private ArrayList<UV> UVs;
	private ArrayList<UVplus> UVsPlus;
	private ArrayList<CC> CCs;
	private ArrayList<Port> ports;
	
	
	private ArrayList<RessourceCard> ressourceCards;
	private ArrayList<DevelopmentCard> developmentCards;
	
	private int VictoryPoint;
	private int longestCursus;
	private int oldestElder;
	private boolean haveTheLongestCursus;
	private boolean haveTheOldestElder;
/*********************** Methods ***********************/
	public Player(String name, Color color){
		this.name=name;
		this.color = color;
		passageOrder=0;
		observers = new ArrayList<Observer>();
		
		ressourceCards = new ArrayList<RessourceCard>();
		developmentCards = new ArrayList<DevelopmentCard>();
		UVs = new ArrayList<UV>();
		UVsPlus = new ArrayList<UVplus>();
		CCs = new ArrayList<CC>();
		ports = new ArrayList<Port>();
		
		VictoryPoint=0;
		longestCursus = 0;
		oldestElder = 0;
		haveTheLongestCursus = false;
		haveTheOldestElder = false;
		
		// -------- test -----------
		for(int i=0 ; i<50 ; i++){
			ressourceCards.add(new RessourceCard(Ressource.BEER));
			ressourceCards.add(new RessourceCard(Ressource.SLEEP));
			ressourceCards.add(new RessourceCard(Ressource.COFFEE));
			ressourceCards.add(new RessourceCard(Ressource.COURS));
			ressourceCards.add(new RessourceCard(Ressource.FOOD));
		}
		for(int i=0 ; i<1 ; i++){
			developmentCards.add(new ElderCard());
			developmentCards.add(new MonopolyCard());
			developmentCards.add(new BuildingCCCard());
			developmentCards.add(new VictoryPointCard());
			developmentCards.add(new DiscoveryCard());
		}
	}
	
	
	
	public String getName(){
		return name;
	}
	public Color getColor(){
		return color;
	}
	public void setPassageOrder(int i){
		passageOrder = i;
	}
	public int getPassageOrder(){
		return passageOrder;
	}
	public ArrayList<UV> getUVs(){
		return UVs;
	}
	public ArrayList<CC> getCCs(){
		return getCCs();
	}
	public ArrayList<Port> getPorts(){
		return ports;
	}
	public ArrayList<RessourceCard> getRessourceCards(){
		return ressourceCards;
	}
	public int getRessourceCards(Ressource ressource){
		int nb = 0;
		for(RessourceCard rc : ressourceCards){
			if(rc.getType() == ressource){
				nb++;
			}
		}
		return nb;
	}
	public void spendRessourceCard(Ressource ressource){
		for(RessourceCard rc : ressourceCards){
			if(rc.getType() == ressource){
				ressourceCards.remove(rc);
				return;
			}
		}
	}
	public ArrayList<DevelopmentCard> getDevelopmentCards(){
		return developmentCards;
	}
	public void addUV(UV UV){
		UVs.add(UV);
	}
	public void removeUV(UV UV){
		UVs.remove(UV);
	}
	public void addUVplus(UVplus UVplus){
		UVsPlus.add(UVplus);
	}
	public void addCC(CC CC){
		CCs.add(CC);
	}
	public int getVictoryPoint(){
		return VictoryPoint;
	}
	public void setVictoryPoint(int vp){
		this.VictoryPoint = vp;
	}
	public int getLongestCursus() {
		return longestCursus;
	}
	public int getOldestElder() {
		return oldestElder;
	}
	public void incrementOldestElder(){
		oldestElder++;
	}
	public boolean haveTheLongestCursus() {
		return haveTheLongestCursus;
	}
	public boolean haveTheOldestElder() {
		return haveTheOldestElder;
	}

	
	
	/* observable methods */
	public void addObserver(Observer obs) {
		observers.add(obs);
		
	}

	public void removeObservers() {
		observers = new ArrayList<Observer>();
	}
	
	public void UpdateObserver(String msg) {
		for(Observer o : observers){
			o.update(msg);
		}
	}
	
	
	
}
