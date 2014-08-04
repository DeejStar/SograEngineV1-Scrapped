package com.soginteractive.engine.core;

import com.badlogic.gdx.InputMultiplexer;

public interface Screen extends com.badlogic.gdx.Screen {

	Screen multiplexer(InputMultiplexer multiplexer);
	
	InputMultiplexer getInputMultiplexer();

}
