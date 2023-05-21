package com.makalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private final JTextArea itemText;
    private final JTextArea solutionText;
    private final JButton saveButton;
    private final JButton searchButton;
    private final GreedyDiscount solver = new GreedyDiscount();

    public GUI() {
        // Icon
        ImageIcon icon = new ImageIcon("assets/stonks.jpg");


        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Greedy Diskon");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(new Color(6, 85, 99));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(title);


        // Bagian Daftar Barang
        // Label
        JLabel daftarBarangLabel = new JLabel("Daftar Barang");
        daftarBarangLabel.setForeground(Color.WHITE);
        daftarBarangLabel.setFont(new Font(daftarBarangLabel.getFont().getName(), daftarBarangLabel.getFont().getStyle(), 20));
        daftarBarangLabel.setPreferredSize(new Dimension(300,30));
        daftarBarangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Tombol
        saveButton = new JButton("Simpan");
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);
        // Text
        itemText = new JTextArea();
        itemText.setMargin(new Insets(7, 7, 7, 7));
        JScrollPane scroll1 = new JScrollPane (itemText);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // Sub-panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(300,500));
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(scroll1);
        subPanel1.setOpaque(false);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(365, 700));
        panel1.setBounds(100,330, 500, 160);
        panel1.setOpaque(false);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 20));
        panel1.add(daftarBarangLabel);
        panel1.add(subPanel1);
        panel1.add(saveButton);


        // Bagian Cari Solusi
        // Label
        JLabel cariLabel = new JLabel("Solusi Greedy");
        cariLabel.setForeground(Color.WHITE);
        cariLabel.setFont(new Font(cariLabel.getFont().getName(), cariLabel.getFont().getStyle(), 20));
        cariLabel.setPreferredSize(new Dimension(300,30));
        cariLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Tombol
        searchButton = new JButton("Cari");
        searchButton.addActionListener(this);
        searchButton.setFocusable(false);
        // Text
        solutionText = new JTextArea();
        solutionText.setMargin(new Insets(7, 7, 7, 7));
        solutionText.setEditable(false);
        JScrollPane scroll2 = new JScrollPane(solutionText);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // Sub-panel 2
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(300,350));
        subPanel2.setLayout(new BorderLayout());
        subPanel2.add(scroll2);
        subPanel2.setOpaque(false);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(365, 700));
        panel2.setBounds(100,330, 500, 160);
        panel2.setOpaque(false);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 20));
        panel2.add(cariLabel);
        panel2.add(subPanel2);
        panel2.add(searchButton);


        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(400,400));
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBackground(new Color(32, 178, 170));
        centerPanel.add(panel1);
        centerPanel.add(panel2);


        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,800));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);


        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));
        setTitle("Greedy Diskon");
        setIconImage(icon.getImage());
        add(mainPanel);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            solver.setItemList(Utils.getItemList(itemText.getText()));
        }
        else if (e.getSource() == searchButton) {
            solutionText.setText(solver.calculateGreedy());
        }
    }
}