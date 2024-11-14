import javax.swing.*;
import java.awt.*;

public class CatDrawing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Преобразуем Graphics к Graphics2D для улучшенной работы
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Цвета для кота
        Color furColor = new Color(150, 100, 50); // Цвет меха
        Color eyeColor = new Color(30, 144, 255); // Синий цвет глаз

        // Рисуем тело кота
        g2.setColor(furColor);
        g2.fillOval(100, 150, 120, 120); // Овал для тела

        // Добавляем черный кружок на животе
        g2.setColor(Color.BLACK);
        g2.fillOval(135, 180, 50, 50); // Черный круг на животе

        // Рисуем голову кота
        g2.setColor(furColor);
        g2.fillOval(135, 100, 50, 50); // Овал для головы

        // Рисуем уши с дополнительными деталями
        int[] xPointsLeftEar = {135, 150, 140};
        int[] yPointsLeftEar = {100, 100, 80};
        g2.fillPolygon(xPointsLeftEar, yPointsLeftEar, 3); // Левое ухо

        int[] xPointsRightEar = {185, 170, 180};
        int[] yPointsRightEar = {100, 100, 80};
        g2.fillPolygon(xPointsRightEar, yPointsRightEar, 3); // Правое ухо

        // Добавляем внутреннюю часть ушей
        g2.setColor(new Color(255, 182, 193)); // Розовый цвет для внутренней части ушей
        int[] xPointsInnerLeftEar = {138, 148, 143};
        int[] yPointsInnerLeftEar = {100, 100, 85};
        g2.fillPolygon(xPointsInnerLeftEar, yPointsInnerLeftEar, 3);

        int[] xPointsInnerRightEar = {182, 172, 177};
        int[] yPointsInnerRightEar = {100, 100, 85};
        g2.fillPolygon(xPointsInnerRightEar, yPointsInnerRightEar, 3);

        // Рисуем глаза
        g2.setColor(Color.WHITE);
        g2.fillOval(145, 115, 12, 12); // Левый глаз
        g2.fillOval(163, 115, 12, 12); // Правый глаз

        g2.setColor(eyeColor);
        g2.fillOval(148, 118, 6, 6); // Левый зрачок
        g2.fillOval(166, 118, 6, 6); // Правый зрачок

        // Рисуем нос
        g2.setColor(Color.BLACK);
        g2.fillOval(155, 130, 8, 5); // Нос

        // Рисуем рот
        g2.drawArc(150, 135, 10, 10, 0, -180); // Левый уголок рта
        g2.drawArc(160, 135, 10, 10, 0, -180); // Правый уголок рта

        // Рисуем усы с изогнутыми линиями
        g2.drawLine(140, 130, 120, 125); // Левый верхний ус
        g2.drawLine(140, 135, 120, 135); // Левый средний ус
        g2.drawLine(140, 140, 120, 145); // Левый нижний ус

        g2.drawLine(180, 130, 200, 125); // Правый верхний ус
        g2.drawLine(180, 135, 200, 135); // Правый средний ус
        g2.drawLine(180, 140, 200, 145); // Правый нижний ус

        // Рисуем лапки
        g2.setColor(furColor);
        g2.fillOval(120, 260, 20, 30); // Левая передняя лапка
        g2.fillOval(180, 260, 20, 30); // Правая передняя лапка


        // Рисуем изогнутый хвост
        g2.setColor(furColor);
        g2.fillArc(60, 200, 80, 50, 20, 180); // Изогнутый хвост в форме дуги
    }

    // Настройка окна для отображения кота
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enhanced Cat Drawing");
        CatDrawing cat = new CatDrawing();
        frame.add(cat);
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
