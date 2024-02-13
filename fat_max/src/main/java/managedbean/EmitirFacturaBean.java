/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import entity.Cliente;
import entity.Fatura;
import entity.FaturaItem;
import entity.FormaPagamento;
import entity.Moeda;
import entity.Produto;
import entity.TipoFatura;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;

/**
 *
 * @author juliosilva
 */
@Named(value = "emitirFacturaBean")
@ViewScoped
public class EmitirFacturaBean implements Serializable {

    /**
     * Creates a new instance of EmitirFacturaBean
     */

    private Cliente cliente;
    private Produto produtoSelect;
    private int quantidadeSelect;
    private List<FaturaItem> listaTemp;
    private FormaPagamento formaPagamento;
    private double totalFatura, troco, valorEntregeCliente, valorTransferencia;
    private boolean validatorParcialTransferencia;
    private Moeda moeda;
    private LoginBean loginBean;
    public EmitirFacturaBean() {
    
    }
    
    @PostConstruct
    public void init(){
        quantidadeSelect = 1;
        listaTemp = new ArrayList<>();
        cliente = null;
        produtoSelect = null;
        totalFatura = 0.0;
        troco = 0.0;
        valorEntregeCliente = 0.0;
        valorTransferencia = 0.0;
        validatorParcialTransferencia = true;
        moeda = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProdutoSelect() {
        return produtoSelect;
    }

    public void setProdutoSelect(Produto produtoSelect) {
        this.produtoSelect = produtoSelect;
    }

    public int getQuantidadeSelect() {
        return quantidadeSelect;
    }

    public void setQuantidadeSelect(int quantidadeSelect) {
        this.quantidadeSelect = quantidadeSelect;
    }

    public List<FaturaItem> getListaTemp() {
        return listaTemp;
    }

    public void setListaTemp(List<FaturaItem> listaTemp) {
        this.listaTemp = listaTemp;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getTotalFatura() {
        return totalFatura;
    }

    public void setTotalFatura(double totalFatura) {
        this.totalFatura = totalFatura;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
    
    public double getValorEntregeCliente() {
        return valorEntregeCliente;
    }

    public void setValorEntregeCliente(double valorEntregeCliente) {
        this.valorEntregeCliente = valorEntregeCliente;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public boolean isValidatorParcialTransferencia() {
        return validatorParcialTransferencia;
    }

    public void setValidatorParcialTransferencia(boolean validatorParcialTransferencia) {
        this.validatorParcialTransferencia = validatorParcialTransferencia;
    }
    
    public void calcularTotalFatura(){

        this.totalFatura += quantidadeSelect * produtoSelect.getPrecoVenda();
        
    }
    
    public void calcularValorCliente(){
        if(this.formaPagamento != null){
            if(this.formaPagamento.getIdFormaPagamento() == 1)
            {
                this.valorEntregeCliente = this.totalFatura;
            }
            else 
            {
                if(this.formaPagamento.getIdFormaPagamento() == 3){
                    validatorParcialTransferencia = false;
                }
                else{
                    
                    validatorParcialTransferencia = true;

                }
                    
                this.valorEntregeCliente = 0.0;
            }
        }
    }
    
    public void calcularTroco(){
        
        this.troco = (this.valorEntregeCliente + this.valorTransferencia) <= this.totalFatura ? 0:(this.valorEntregeCliente + this.valorTransferencia) - (this.totalFatura);
    }
    
    public void adicionar(){
        
        FaturaItem item = new FaturaItem();
        item.setIdFactura(0);
        item.setIdProduto(produtoSelect);
        item.setQuantidade(quantidadeSelect);
        item.setTotal(quantidadeSelect * produtoSelect.getPrecoVenda());
        listaTemp.add(item);
        
        calcularTotalFatura();
        calcularTroco();
    }
    
    public void removerItemListaTemp(FaturaItem item){
     
         listaTemp.remove(item);
    }
    
    
    private static String convertInvoiceToJson(Fatura invoice) {
        // Converta a instância de Invoice para uma representação JSON
        // Você pode usar uma biblioteca como Gson, Jackson, etc.
        // Retorne a string JSON resultante
        // Exemplo simples (não recomendado para produção):
        return "{\"idFatura\":\"" + invoice.getIdFatura() + "\",\"idUtilizador\":\"" +
                "\"id_cliente\":\"" + invoice.getIdCliente().getIdCliente() + "\"," +
                "\"valor_total\":\"" + invoice.getValorTotal() + "\"," +
                "\"numeracao\":\"" + invoice.getNumeracao() + "\"," +
                "\"id_moeda\":\"" + invoice.getIdMoeda().getIdMoeda() + "\"," +
                 "\"id_utilizador\":\"" +
                invoice.getIdUtilizador() + "\",\"items\":" + convertItemsToJson(invoice.getItems()) + "}";
    }
    
    private static String convertItemsToJson(List<FaturaItem> items) {
        // Converta a lista de itens para uma representação JSON
        // Você pode usar uma biblioteca como Gson, Jackson, etc.
        // Retorne a string JSON resultante
        // Exemplo simples (não recomendado para produção):
        StringBuilder json = new StringBuilder("[");
        for (FaturaItem item : items) {
            json.append("{\"id_produto\":\"").append(item.getIdProduto()).append("\",\"total\":")
                .append(item.getQuantidade()).append(",\"quantidade\":").append(item.getQuantidade()).append("},");
        }
        json.deleteCharAt(json.length() - 1);  // Remover a vírgula extra no final
        json.append("]");
        return json.toString();
    }
    public void salvarFactura() throws MalformedURLException, IOException{
        
        Fatura fatura = new Fatura();
        fatura.setIdMoeda(moeda);
        fatura.setIdTipoFatura(new TipoFatura(1));
        fatura.setIdCliente(cliente);
        fatura.setIdUtilizador(loginBean.utilizadorLogado());
        fatura.setItems(listaTemp);
        fatura.setNumeracao("nnn");
        
        
        
        URL url = new URL("https://exemplo.com/api/invoices");
        // Criar uma conexão HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Definir método POST
        connection.setRequestMethod("POST");

        // Habilitar envio de dados
        connection.setDoOutput(true);
                // Converter Invoice para formato JSON (você pode usar uma biblioteca como Gson)
        String jsonInputString = convertInvoiceToJson(fatura);

        // Definir cabeçalhos da requisição
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
        //fatura.set
        
        // Obter resposta da API
            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            // Fechar a conexão
            connection.disconnect();
        }
    }    
}
