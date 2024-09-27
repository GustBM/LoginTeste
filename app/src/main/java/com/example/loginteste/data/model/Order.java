package com.example.loginteste.data.model;

import java.util.List;

public class Order {
    /*public Order(String placa, String id, String autorizacao, String data, String marcaModelo, boolean doDeepValidation, boolean doMotoDeepVAlidation, boolean motoAutomaticAproval, boolean doPhotoOfPhotoValidation, double valor, boolean receberPlacas, String nomeRecebedor, String cpfRecebedor, boolean chassiDeepValidation, boolean jumpButtonEnabled, boolean estampBiometria, boolean justificaChassi, boolean cercaAtiva, double distanciaCerca, String categoria, String ufSerpro, String municipio, String statusSerpro, int tipoVeiculo, String latitude, String longitude, String latitudeRetirada, String longitudeRetirada, boolean validarAfixador, String renavam, String cpfCondutor, String nomeCondutor, String cpfProprietario, String dianteiraSerial, String traseiraSerial, String segundaTraseiraSerial, String dianteiraB64, String traseiraB64, String segundaTraseiraB64, Dianteira dianteira, Dianteira traseira, Dianteira segundaTraseira, String chassi, int tentativasChassi, int dianteiraQR, int traseiraQR, int segundaTraseiraQR, int tentativasQrOcr, String serproId, int qtdPlacas, List<Step> steps) {
        this.placa = placa;
        this.id = id;
        this.autorizacao = autorizacao;
        this.data = data;
        this.marcaModelo = marcaModelo;
        this.doDeepValidation = doDeepValidation;
        this.doMotoDeepVAlidation = doMotoDeepVAlidation;
        this.motoAutomaticAproval = motoAutomaticAproval;
        this.doPhotoOfPhotoValidation = doPhotoOfPhotoValidation;
        this.valor = valor;
        this.receberPlacas = receberPlacas;
        this.nomeRecebedor = nomeRecebedor;
        this.cpfRecebedor = cpfRecebedor;
        this.chassiDeepValidation = chassiDeepValidation;
        this.jumpButtonEnabled = jumpButtonEnabled;
        this.estampBiometria = estampBiometria;
        this.justificaChassi = justificaChassi;
        this.cercaAtiva = cercaAtiva;
        this.distanciaCerca = distanciaCerca;
        this.categoria = categoria;
        this.ufSerpro = ufSerpro;
        this.municipio = municipio;
        this.statusSerpro = statusSerpro;
        this.tipoVeiculo = tipoVeiculo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latitudeRetirada = latitudeRetirada;
        this.longitudeRetirada = longitudeRetirada;
        this.validarAfixador = validarAfixador;
        this.renavam = renavam;
        this.cpfCondutor = cpfCondutor;
        this.nomeCondutor = nomeCondutor;
        this.cpfProprietario = cpfProprietario;
        this.dianteiraSerial = dianteiraSerial;
        this.traseiraSerial = traseiraSerial;
        this.segundaTraseiraSerial = segundaTraseiraSerial;
        this.dianteiraB64 = dianteiraB64;
        this.traseiraB64 = traseiraB64;
        this.segundaTraseiraB64 = segundaTraseiraB64;
        this.dianteira = dianteira;
        this.traseira = traseira;
        this.segundaTraseira = segundaTraseira;
        this.chassi = chassi;
        this.tentativasChassi = tentativasChassi;
        this.dianteiraQR = dianteiraQR;
        this.traseiraQR = traseiraQR;
        this.segundaTraseiraQR = segundaTraseiraQR;
        this.tentativasQrOcr = tentativasQrOcr;
        this.serproId = serproId;
        this.qtdPlacas = qtdPlacas;
        this.steps = steps;
    }*/

    public Order(String placa) {
        this.placa = placa;
    }

    private String placa;
    private String id;
    private String autorizacao;
    private String data;
    private String marcaModelo;
    private boolean doDeepValidation;
    private boolean doMotoDeepVAlidation;
    private boolean motoAutomaticAproval;
    private boolean doPhotoOfPhotoValidation;
    private double valor;
    private boolean receberPlacas;
    private String nomeRecebedor;
    private String cpfRecebedor;
    private boolean chassiDeepValidation;
    private boolean jumpButtonEnabled;
    private boolean estampBiometria;
    private boolean justificaChassi;
    private boolean cercaAtiva;
    private double distanciaCerca;
    private String categoria;
    private String ufSerpro;
    private String municipio;
    private String statusSerpro;
    private int tipoVeiculo;
    private String latitude;
    private String longitude;
    private String latitudeRetirada;
    private String longitudeRetirada;
    private boolean validarAfixador;
    private String renavam;
    private String cpfCondutor;
    private String nomeCondutor;
    private String cpfProprietario;
    private String dianteiraSerial;
    private String traseiraSerial;
    private String segundaTraseiraSerial;
    private String dianteiraB64;
    private String traseiraB64;
    private String segundaTraseiraB64;
    private Dianteira dianteira;
    private Dianteira traseira;
    private Dianteira segundaTraseira;
    private String chassi;
    private int tentativasChassi;
    private int dianteiraQR;
    private int traseiraQR;
    private int segundaTraseiraQR;
    private int tentativasQrOcr;
    private String serproId;
    private int qtdPlacas;
    private List<Step> steps;

    public String getPlaca() {
        return placa;
    }

    public String getId() {
        return id;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public String getData() {
        return data;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public boolean isDoDeepValidation() {
        return doDeepValidation;
    }

    public boolean isDoMotoDeepVAlidation() {
        return doMotoDeepVAlidation;
    }

    public boolean isMotoAutomaticAproval() {
        return motoAutomaticAproval;
    }

    public boolean isDoPhotoOfPhotoValidation() {
        return doPhotoOfPhotoValidation;
    }

    public double getValor() {
        return valor;
    }

    public boolean isReceberPlacas() {
        return receberPlacas;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public String getCpfRecebedor() {
        return cpfRecebedor;
    }

    public boolean isChassiDeepValidation() {
        return chassiDeepValidation;
    }

    public boolean isJumpButtonEnabled() {
        return jumpButtonEnabled;
    }

    public boolean isEstampBiometria() {
        return estampBiometria;
    }

    public boolean isJustificaChassi() {
        return justificaChassi;
    }

    public boolean isCercaAtiva() {
        return cercaAtiva;
    }

    public double getDistanciaCerca() {
        return distanciaCerca;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getUfSerpro() {
        return ufSerpro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getStatusSerpro() {
        return statusSerpro;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitudeRetirada() {
        return latitudeRetirada;
    }

    public String getLongitudeRetirada() {
        return longitudeRetirada;
    }

    public boolean isValidarAfixador() {
        return validarAfixador;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getCpfCondutor() {
        return cpfCondutor;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public String getDianteiraSerial() {
        return dianteiraSerial;
    }

    public String getTraseiraSerial() {
        return traseiraSerial;
    }

    public String getSegundaTraseiraSerial() {
        return segundaTraseiraSerial;
    }

    public String getDianteiraB64() {
        return dianteiraB64;
    }

    public String getTraseiraB64() {
        return traseiraB64;
    }

    public String getSegundaTraseiraB64() {
        return segundaTraseiraB64;
    }

    public Dianteira getDianteira() {
        return dianteira;
    }

    public Dianteira getTraseira() {
        return traseira;
    }

    public Dianteira getSegundaTraseira() {
        return segundaTraseira;
    }

    public String getChassi() {
        return chassi;
    }

    public int getTentativasChassi() {
        return tentativasChassi;
    }

    public int getDianteiraQR() {
        return dianteiraQR;
    }

    public int getTraseiraQR() {
        return traseiraQR;
    }

    public int getSegundaTraseiraQR() {
        return segundaTraseiraQR;
    }

    public int getTentativasQrOcr() {
        return tentativasQrOcr;
    }

    public String getSerproId() {
        return serproId;
    }

    public int getQtdPlacas() {
        return qtdPlacas;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public static class Dianteira {
        private int validar;
        private String nivelValidacao;
    }

    public static class Step {
        private int existeNoFluxo;
        private int ordemFluxo;
        private String tituloStep;
        private String detailsStep;
        private String nivelValidacao;
        private String classe;
    }
}
