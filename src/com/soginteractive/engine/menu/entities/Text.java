package com.soginteractive.engine.menu.entities;

import static com.soginteractive.engine.core.util.ScriptUtils.printBoolean;
import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.AbstractEntity;
import com.soginteractive.engine.misc.BitmapFont;

public class Text extends AbstractEntity {

	private String sequence;
	private int wrapAlign, labelAlign, lineAlign;
	private boolean wrap, ellipse;

	private BitmapFont font;
	private Color color;
	private LabelStyle style;
	private Label label;

	private final String OBJ = "Text";
	private final String SEQ = "sequence";
	private final String WRPA = "wrapAlign";
	private final String LBLA = "labelAlign";
	private final String LINA = "lineAlign";
	private final String WRP = "wrap";
	private final String ELPS = "ellipse";
	private final String FONTP = "fontPath";
	private final String CLR = "color";

	public Text(String name) {
		super(name);
		sequence = "";
		wrap = false;
		ellipse = false;
	}

	public Text sequence(String sequence) {
		this.sequence = sequence;
		return this;
	}

	public Text wrapAlign(int wrapAlign) {
		this.wrapAlign = wrapAlign;
		return this;
	}

	public Text labelAlign(int labelAlign) {
		this.labelAlign = labelAlign;
		return this;
	}

	public Text lineAlign(int lineAlign) {
		this.lineAlign = lineAlign;
		return this;
	}

	public Text wrap(boolean wrap) {
		this.wrap = wrap;
		return this;
	}

	public Text ellipse(boolean ellipse) {
		this.ellipse = ellipse;
		return this;
	}

	public Text font(String path) {
		font(path, false);
		return this;
	}

	public Text font(String path, boolean flip) {
		font(Gdx.files.internal(path), flip);
		return this;
	}

	public Text font(FileHandle handle) {
		font(handle, false);
		return this;
	}

	public Text font(FileHandle handle, boolean flip) {
		font(new BitmapFont(handle, flip));
		return this;
	}

	public Text font(BitmapFont font) {
		this.font = font;
		return this;
	}

	public Text color(Color color) {
		this.color = color;
		return this;
	}

	public Text style(BitmapFont font) {
		style(font, Color.DARK_GRAY);
		return this;
	}

	public Text style(BitmapFont font, Color color) {
		style(new LabelStyle(font, color));
		return this;
	}

	public Text style(LabelStyle style) {
		this.style = style;
		return this;
	}

	public String getSequence() {
		return sequence;
	}

	public boolean isWrapped() {
		return wrap;
	}

	public boolean isEllipsed() {
		return ellipse;
	}

	public BitmapFont getFont() {
		return font;
	}

	public Color getColor() {
		return color;
	}

	public LabelStyle getStyle() {
		return style;
	}

	@Override
	public Actor getActor() {
		return getLabel();
	}

	private Label getLabel() {
		checkLabel();
		return label;
	}

	private void checkLabel() {
		if (label == null) {
			checkStyle();
		}

		label.setWrap(wrap);
		label.setEllipse(ellipse);
		ckeckAlignment();
	}

	private void checkStyle() {
		if (font != null) {
			if (color != null) {
				style(font, color);
			}

			else {
				style(font, Color.DARK_GRAY);
			}
		}

		else {
			style(new LabelStyle());
		}

		label = new Label(sequence, style);
	}

	private void ckeckAlignment() {
		if (wrapAlign != 0) {
			label.setAlignment(wrapAlign);
		}

		else {
			if (labelAlign != 0 && lineAlign != 0) {
				label.setAlignment(labelAlign, lineAlign);
			}

			else {
				label.setAlignment(Align.center);
			}
		}
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			super.write(json);
			json.writeValue(SEQ, sequence);
			json.writeValue(WRPA, wrapAlign);
			json.writeValue(LBLA, labelAlign);
			json.writeValue(LINA, lineAlign);
			json.writeValue(WRP, wrap);
			json.writeValue(ELPS, ellipse);
			json.writeValue(FONTP, font.getFontPath());
			json.writeValue(CLR, color);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		super.read(json, jsonData);
		sequence(child.getString(SEQ));
		wrapAlign(child.getInt(WRPA));
		labelAlign(child.getInt(LBLA));
		lineAlign(child.getInt(LINA));
		wrap(child.getBoolean(WRP));
		ellipse(child.getBoolean(ELPS));
		font(child.getString(FONTP));
		color(json.fromJson(Color.class, child.get(CLR).toString()));
	}

	public void printJson() {
		super.printJson();
		printString(SEQ, sequence);
		printInt(WRPA, wrapAlign);
		printInt(LBLA, labelAlign);
		printInt(LINA, lineAlign);
		printBoolean(WRP, wrap);
		printBoolean(ELPS, ellipse);
	}

}
