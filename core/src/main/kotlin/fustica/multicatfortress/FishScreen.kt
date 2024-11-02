package fustica.multicatfortress

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20

class FishScreen: Screen, InputProcessor {
    override fun show() {
     
    }

    override fun render(p0: Float) {
        Gdx.gl.glClearColor(1f, 0f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    override fun resize(p0: Int, p1: Int) {
        
    }

    override fun pause() {
        
    }

    override fun resume() {
        
    }

    override fun hide() {
        
    }

    override fun dispose() {
        
    }

    override fun keyDown(p0: Int): Boolean {
        return true
    }

    override fun keyUp(p0: Int): Boolean {
        return true
    }

    override fun keyTyped(p0: Char): Boolean {
        return true
    }

    override fun touchDown(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return true
    }

    override fun touchUp(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return true
    }

    override fun touchCancelled(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return true
    }

    override fun touchDragged(p0: Int, p1: Int, p2: Int): Boolean {
        return true
    }

    override fun mouseMoved(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun scrolled(p0: Float, p1: Float): Boolean {
        return true
    }
}