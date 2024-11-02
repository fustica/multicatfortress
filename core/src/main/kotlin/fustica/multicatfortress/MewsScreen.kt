package fustica.multicatfortress

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class MewsScreen: Screen, InputProcessor{

    var mews = 0
    val cat = Rectangle(200f, 200f, 100f, 100f)

    //text
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    //clics
    var mouseClickCoordinate = Vector2(0f,0f)
    var mouseClicked = false




    override fun show() {
        //text
        batch = SpriteBatch ()
        font = BitmapFont()
        font.setColor(Color.BLACK)
    }

    override fun render(p0: Float) {
        Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        //text
        batch.begin()
        font.draw(batch, "Mews: "+mews, 100f, 400f)
        batch.end ()

        val shapeRenderer: ShapeRenderer = ShapeRenderer()
        shapeRenderer.begin(ShapeType.Filled)
        shapeRenderer.setColor(1f, 0.5f, 0.5f, 1f)

        shapeRenderer.rect(cat.x, cat.y, cat.width, cat.height)
        shapeRenderer.end()
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
        mouseClicked = false
        return true
    }

    override fun keyTyped(p0: Char): Boolean {
        return true
    }

    override fun touchDown(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        mouseClickCoordinate.x = p0.toFloat()
        mouseClickCoordinate.y = p1.toFloat()

        if (mouseClickCoordinate.x > cat.x
            && mouseClickCoordinate.x < cat.x + cat.width
            && mouseClickCoordinate.y > cat.y
            && mouseClickCoordinate.y < cat.y + cat.height){

            mews += 1
        }

        mouseClicked = true
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