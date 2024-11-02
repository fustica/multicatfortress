package fustica.multicatfortress

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2


class Main : Game(), InputProcessor {

    //train
    val train = Rectangle(100f, 500f, 100f, 100f)
    var trainVerticalVelocity = 0f
    val gravity = 0.1f

    //text
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont


    //clics
    var mouseClickCoordinate = Vector2(0f,0f)
    var mouseClicked = false

    //screens
    lateinit var mewsScreen: MewsScreen

    override fun create() {

        mewsScreen = MewsScreen()


        //text
        batch = SpriteBatch ()
        font = BitmapFont()
        font.setColor(Color.BLACK)


        //clicks
        Gdx.input.setInputProcessor(this)
    }

    override fun render() {

        Gdx.gl.glClearColor(0.5f, 1f, 0.5f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        val shapeRenderer: ShapeRenderer = ShapeRenderer()
        shapeRenderer.begin(ShapeType.Filled)
        //shapeRenderer.rect(100f,100f,100f,100f)

        //gravity
        trainVerticalVelocity += gravity
        train.y -= trainVerticalVelocity

        if (train.y < 10) {
            train.y = 10f
            trainVerticalVelocity = 0f
        }
        //jump
        if (trainVerticalVelocity == 0f && mouseClicked) {
            trainVerticalVelocity = -5f
        }

        shapeRenderer.rect(train.x, train.y, train.height, train.width)
        shapeRenderer.end()

        //text
        batch.begin()
        font.draw(batch, "click: "+mouseClickCoordinate.x+", "+mouseClickCoordinate.y , 300f, 300f)
        batch.end ()


        super.render()
    }

    override fun keyDown(p0: Int): Boolean {
        if (Keys.NUM_1 == p0) {
            Gdx.input.setInputProcessor(mewsScreen)
            setScreen(mewsScreen)
        }

        return true
    }

    override fun keyUp(p0: Int): Boolean {
        return true    }

    override fun keyTyped(p0: Char): Boolean {
        return true    }

    override fun touchDown(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        mouseClickCoordinate.x = p0.toFloat()
        mouseClickCoordinate.y = p1.toFloat()
        mouseClicked = true
        return true    }


    override fun touchUp(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        mouseClicked = false
        return true    }

    override fun touchCancelled(p0: Int, p1: Int, p2: Int, p3: Int): Boolean {
        return true    }

    override fun touchDragged(p0: Int, p1: Int, p2: Int): Boolean {
        return true    }

    override fun mouseMoved(p0: Int, p1: Int): Boolean {
        return true    }

    override fun scrolled(p0: Float, p1: Float): Boolean {
        return true    }
}
