package fapi.poo.listacarro.carro;

import fapi.poo.listacarro.banco.Banco;
import fapi.poo.listacarro.banco.FabricaBanco;
import fapi.poo.listacarro.bluetooth.Bluetooth;
import fapi.poo.listacarro.bluetooth.FabricaBluetooth;
import fapi.poo.listacarro.motor.FabricaMotor;
import fapi.poo.listacarro.motor.Motor;
import fapi.poo.listacarro.pneu.FabricaPneu;
import fapi.poo.listacarro.pneu.Pneu;
import fapi.poo.listacarro.porta.FabricaPorta;
import fapi.poo.listacarro.porta.Porta;
import fapi.poo.listacarro.roda.FabricaRoda;
import fapi.poo.listacarro.roda.Roda;
import fapi.poo.listacarro.tanque.FabricaTanque;
import fapi.poo.listacarro.tanque.Tanque;
import fapi.poo.listacarro.tetosolar.FabricaTetoSolar;
import fapi.poo.listacarro.tetosolar.TetoSolar;

public class FabricaCarro {
    public Carro criaCarro(float litrosTanque, float autonomia, float durabilidadePneu, String temStep, String temBluetooth, String temTetoSolar){

        FabricaBanco fabricaBanco = new FabricaBanco();
        FabricaMotor fabricaMotor = new FabricaMotor();
        FabricaPneu fabricaPneu = new FabricaPneu();
        FabricaTanque fabricaTanque = new FabricaTanque();
        FabricaPorta fabricaPorta = new FabricaPorta();
        FabricaRoda fabricaRoda = new FabricaRoda();
        FabricaBluetooth fabricaBluetooth = new FabricaBluetooth();
        FabricaTetoSolar fabricaTetoSolar = new FabricaTetoSolar();

        //Banco
        Banco banco[] = new Banco[3];
        banco[0] = fabricaBanco.criaBanco();
        banco[1] = fabricaBanco.criaBanco();
        banco[2] = fabricaBanco.criaBanco();

        //motor
        Motor motor = fabricaMotor.criaMotor(autonomia);

        //pneu
        Pneu pneu[] = new Pneu[4];
        pneu[0] = fabricaPneu.criaPneu(durabilidadePneu);
        pneu[1] = fabricaPneu.criaPneu(durabilidadePneu);
        pneu[2] = fabricaPneu.criaPneu(durabilidadePneu);
        pneu[3] = fabricaPneu.criaPneu(durabilidadePneu);


        //tanque
        Tanque tanque = fabricaTanque.criaTanque(litrosTanque);

        //Porta
        Porta porta[] = new Porta[4];
        porta[0] = fabricaPorta.criaPorta();
        porta[1] = fabricaPorta.criaPorta();
        porta[2] = fabricaPorta.criaPorta();
        porta[3] = fabricaPorta.criaPorta();

        //Roda
        Roda roda[] = new Roda[4];
        roda[0] = fabricaRoda.criaRoda();
        roda[1] = fabricaRoda.criaRoda();
        roda[2] = fabricaRoda.criaRoda();
        roda[3] = fabricaRoda.criaRoda();

        Carro carro = new Carro(motor,roda,pneu,banco,porta,tanque);

        //step
        if("S".equalsIgnoreCase(temStep)){
            Roda stepRoda = fabricaRoda.criaRoda();
            Pneu stepPneu = fabricaPneu.criaPneu(durabilidadePneu);
            carro.setStepPneu(stepPneu);
            carro.setStepRoda(stepRoda);

        }
        //bluetooth
        if("S".equalsIgnoreCase(temBluetooth) ){
            Bluetooth bluetooth = fabricaBluetooth.criaBluetooth();
            carro.setBluetooth(bluetooth);
        }

        //tetoSolar
        if ("S".equalsIgnoreCase(temTetoSolar))
        {
            TetoSolar tetoSolar = fabricaTetoSolar.criaTetoSolar();
            carro.setTetoSolar(tetoSolar);
        }

        return carro;
    }
}
