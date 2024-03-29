package pkg2048.v1.pkg0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class CustomPanel extends JPanel implements KeyListener{
    private final static int SIZE = 500;
    private final static long serialVersionUID = 1L;
    private final table t;

    public CustomPanel(table t) {
        setFocusable(true);
        setPreferredSize(new Dimension(SIZE, SIZE));
        addKeyListener(this);
        this.t = t;
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        g.setColor(new Color(0xFF555555));
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, SIZE*2/table.N/5));

        FontMetrics metrics = g.getFontMetrics();

        g.fillRect(0, 0, SIZE, SIZE);

        if (t == null) return;

        for (int row = 0; row < table.N; row++)
            for (int col = 0; col < table.N; col++){
                int val = t.getvalue(row, col);
                g.setColor(getColor(val));
                g.fillRoundRect(
                    (15*col+1)*SIZE/table.N/15,
                    (15*row+1)*SIZE/table.N/15,
                    SIZE*13/table.N/15,
                    SIZE*13/table.N/15,
                    SIZE/table.N/15,
                    SIZE/table.N/15
                );
                g.setColor(val <= 8 ? Color.BLACK : Color.WHITE);
                if (val == 0) continue;
                g.drawString(
                    String.valueOf(val),
                    (int) ((2*col+1)*SIZE/table.N/2)-metrics.stringWidth(String.valueOf(val))/2,
                    (int) ((2*row+1)*SIZE/table.N/2)+metrics.getHeight()/2
                );
            }
    }

    private Color getColor (int n){
        switch (n) {
            case 0: return new Color(0xFFCDC0B4);
            case 2: return new Color(0xFFEFE5DC);
            case 4: return new Color(0xFFF0DFCA);
            case 8: return new Color(0xFFF5B37A);
            case 16: return new Color(0xFFEF9254);
            case 32: return new Color(0xFFF9845D);
            case 64: return new Color(0xFFED6531);
            case 128: return new Color(0xFFDEB85E);
            case 256: return new Color(0xFFF6CD4E);
            case 512: return new Color(0xFFDBB43B);
            case 1024: return new Color(0xFFF6CD4E);
            case 2048: return new Color(0xFFF0C117);
            default: throw new IllegalArgumentException("'n' have to be a power of two, passed: "+n);
        }
    }

    @Override
    public void keyReleased (KeyEvent e){}
    @Override
    public void keyPressed (KeyEvent e){
        if(t.getgameover()) return;

        try{
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    t.UP();
                    break;
                case KeyEvent.VK_DOWN:
                    t.DOWN();
                    break;
                case KeyEvent.VK_RIGHT:
                    t.RIGHT();
                    break;
                case KeyEvent.VK_LEFT:
                    t.LEFT();
                    break;
            }
        } catch (IOException exc){
            exc.printStackTrace();
        }
        revalidate();
        repaint();
    }
    @Override
    public void keyTyped (KeyEvent e) {
        
    }
}
