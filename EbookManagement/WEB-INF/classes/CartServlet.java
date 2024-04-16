import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CartServlet extends HttpServlet {

    String[] books={"Americanah","American Psycho","David Copperfield","Don Quixote","ShuggieBain","The God of SmallThings","White Noise"};
    String[] description={"Americanah is a powerful novel by Chimamanda Ngozi Adichie, exploring themes of race, identity, and belonging through the lives of two Nigerian immigrants in the United States. It offers a poignant commentary on cultural assimilation and the complexities of the immigrant experience."
                            ,"American Psycho is a novel by Bret Easton Ellis that delves into the mind of Patrick Bateman, a wealthy New York City investment banker who leads a double life as a sadistic serial killer, exploring themes of consumerism, identity, and the darkness lurking beneath the veneer of 1980s yuppie culture."
                            ,"David Copperfield is a classic novel by Charles Dickens, depicting the life journey of its titular character from childhood adversity to eventual triumph, exploring themes of resilience, love, and personal growth amidst the social upheavals of Victorian England."
                            ,"Don Quixote is a timeless Spanish novel written by Miguel de Cervantes. It follows the adventures of a delusional knight who seeks to revive chivalry, often leading to humorous and poignant encounters that explore the themes of reality versus fantasy."
                            ,"Shuggie Bain is a poignant novel by Douglas Stuart, chronicling the life of a young boy named Shuggie growing up in poverty-stricken Glasgow, navigating family struggles, and his own identity amidst his mother's battle with addiction."
                            ,"The God of Small Things is a poignant novel by Arundhati Roy, delving into the intricate lives of an Indian family, exploring themes of love, caste, and societal norms through the lens of personal tragedy and forbidden passion. It's a lyrical narrative that captures the complexities of human relationships against the backdrop of Kerala's lush landscape."
                            ,"White Noise is a novel by Don DeLillo that explores the anxiety of modern life through the lens of a professor and his family grappling with the fear of death and the influence of media in shaping their perceptions. With its satirical tone and existential themes, the book delves into the absurdities of contemporary society."
                            };
    int[] price={100,299,78,69,20,120,100};
    int request_size=0;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int total=0;
                response.setContentType("text/html");
                PrintWriter out=response.getWriter();
                String value=request.getParameter("value");
                String[] requested_books=value.substring(1,value.length()-2).split(",");
                out.println("<!DOCTYPE html><html><head><title>EbookManagement</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><link rel=\"stylesheet\" href=\"style.css\"/></head><body><header><h class=\"header-head\">Welcome to Ebook Management Cart</h></header><div class=\"books\">");
                for(int i=0;i<requested_books.length;i++){
                    for(int j=0;j<books.length;j++){
                        if(requested_books[i].equals(books[j])){
                            out.println("<div class=\"book\">");
                            out.println("<img src=\"./static/img/"+books[i]+".jpg\" class=\"book-img\" alt=\"\">");
                            out.println("<div class=\"content\">");
                            out.println("<span class=\"content-head\">"+books[i]+"</span>");
                            out.println("<p class=\"content-body\">"+description[i]+"</p>");
                            out.println("</div>");
                            out.println("<span class=\"price\">₹"+price[i]+"</span>");
                            out.println("</div>");
                            total=total+price[j];
                        }
                    }

                }
                out.println("</div>");
                out.println("<div class=\"checkout\"><div class=\"estimate\"><h>TOTAL<span class=\"total\">₹"+total+"</span></h></div><div class=\"form\"><form action=\"Confirmation\" method=\"GET\">FIRST NAME:<input type=\"text\" required><br>LAST NAME:<input type=\"text\" required><br>ADDRESS:<input type=\"text\" required><br>PHONE NUMBER:<input type=\"number\" required><br><button id=\"submit_butt\" type=\"submit\">SUBMIT</button></form></div></div>");
                out.println(" <script src=\"script.js\"></script> </body></html>");
        
    }
}
