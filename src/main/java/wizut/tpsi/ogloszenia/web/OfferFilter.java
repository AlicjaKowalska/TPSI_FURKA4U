/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.web;

/**
 *
 * @author alicj
 */
public class OfferFilter {

    private int manufacturerId;
    private int modelId;

    public int getManufacturerId() {
        return manufacturerId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
}
