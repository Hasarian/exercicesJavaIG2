package labo5;

import javax.swing.*;
import java.awt.*;

public class IESNpanel extends JPanel
{
    JLabel image,adresse,tel,siteInternet;
     public IESNpanel()
     {
         adresse=new JLabel("<html>    <p>adresse:</p>    <p>Rue Joseph Calozet 19</p><p> 5000 Namur</p></html>");
         tel=new JLabel("tel: +32 81 46 86 10");
         siteInternet= new JLabel("<html><p>site:</p><p>http://www.henallux.be/namur-iesn</p></html>");
         ImageIcon savedPic=new ImageIcon(".\\iesnImage.jpg");
         System.out.println(savedPic);
         image=new JLabel("",savedPic,JLabel.CENTER);
         setLayout(new GridBagLayout());
         GridBagConstraints contraints = new GridBagConstraints();
         contraints.fill=GridBagConstraints.HORIZONTAL;
         contraints.gridwidth=3;
         contraints.gridx=0;
         contraints.gridy=0;
         add(image,contraints);

         contraints.gridwidth=1;
         contraints.gridy=1;
         add(siteInternet,contraints);

         contraints.gridy=3;
         add(tel,contraints);

         contraints.fill=GridBagConstraints.VERTICAL;
         contraints.gridheight=2;
         contraints.gridy=2;
         contraints.gridx=2;
         add(adresse,contraints);
     }
}
