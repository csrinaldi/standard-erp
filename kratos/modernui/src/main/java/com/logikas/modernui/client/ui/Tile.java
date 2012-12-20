/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.modernui.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasAnimation;
import com.google.gwt.user.client.ui.Image;
import com.logikas.modernui.client.ui.constant.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * ModernUi
 *
 * Documentation of Class Tile
 *
 *
 * Package: com.logikas.modernui.client.ui Last modification: 19/12/2012 File:
 * Tile.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class Tile extends Anchor implements HasAnimation {

    private List<Image> images = new ArrayList<Image>();
    private boolean animation = false;
    private DivWidget imageContainer;

    public Tile() {
        setStylePrimaryName(Constants.TILE);

        imageContainer = new DivWidget(Constants.IMAGE_WRAPPER);

        getElement().appendChild(imageContainer.getElement());
    }

    public void addImage(Image image) {
        images.add(image);
        if (!isAnimationEnabled()) {
            imageContainer.add(image);
        }
    }

    public boolean isAnimationEnabled() {
        return false;
    }

    public void setAnimationEnabled(boolean enable) {
        this.animation = enable;
    }

    public void setWide(boolean wide) {
        if (wide) {
            this.addStyleName(Constants.WIDE);
        } else {
            this.removeStyleName(Constants.WIDE);
        }
    }
}
