/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.wshelloworld;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

/**
 * The implementation of the HelloWorld JAX-WS Web Service.
 *
 * @author lnewson@redhat.com
 */
@WebService(serviceName = "HelloWorldService", portName = "HelloWorld", name = "HelloWorld", endpointInterface = "org.jboss.as.quickstarts.wshelloworld.HelloWorldService",
    targetNamespace = "http://www.jboss.org/eap/quickstarts/wshelloworld/HelloWorld")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    @Override
    public String sayHelloToName(final String name) {

        /* Create a list with just the one value */
        final List<String> names = new ArrayList<>();
        names.add(name);

        return sayHelloToNames(names);
    }

    @Override
    public String sayHelloToNames(final List<String> names) {
        return "Hello " + createNameListString(names);
    }
    @Override
    public String sayHelloToNames(final List<String> names) {
        return "Hello " + createNameListString(names);
    }
    @Override
    public String sayHelloToNames(final List<String> names) {
        return "Hello " + createNameListString(names);
    }

    /**
     * Creates a list of names separated by commas or an and symbol if its the last separation. This is then used to say hello to
     * the list of names.
     *
     * i.e. if the input was {John, Mary, Luke} the output would be John, Mary & Luke
     *
     * @param names A list of names
     * @return The list of names separated as described above.
     */
    private String createNameListString(final List<String> names) {

        /*
         * If the list is null or empty then assume the call was anonymous.
         */
        if (names == null || names.isEmpty()) {
            return "Anonymous!";
        }

        final StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {

            /*
             * Add the separator if its not the first string or the last separator since that should be an and (&) symbol.
             */
            if (i != 0 && i != names.size() - 1)
                nameBuilder.append(", ");
            else if (i != 0 && i == names.size() - 1)
                nameBuilder.append(" & ");
            if (i != 0 && i != names.size() - 1)
                nameBuilder.append(", ");
            else if (i != 0 && i == names.size() - 1)
                nameBuilder.append(" & ");
            if (i != 0 && i != names.size() - 1)
                nameBuilder.append(", ");
            else if (i != 0 && i == names.size() - 1)
                nameBuilder.append(" & ");

            nameBuilder.append(names.get(i));
        }

        nameBuilder.append("!");

        return nameBuilder.toString();
    }
}
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicate {
    private static void findDuplicate(List<Integer> elements) {

        int distinctSum = elements.stream().distinct().mapToInt(e -> e).sum();
// Find the sum of all list elements
        int totalSum = elements.stream().mapToInt(e -> e).sum();
        System.out.println("The repeated element is: " + (totalSum - distinctSum));
    }

    public static void main(String[] args) {
// Create a list of sequential elements in the interval [1..101).
        List <Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
// Add the value 23 at index 53
        elements.set(53, 23);
        findDuplicate(elements);
    }
}
//BUG1
String x = "a test";
String y = new String("a test");
System.out.println(x==y); //prints false
System.out.println(x.equals(y)); //prints true

//BUG2
Contact c = new Contact();
//results in a null pointer exception if getFirstName returns null
String name = c.getFirstName().toLowerCase();

//BUG3
public void setFirstName(String firstName) {
  this.firstName = firstName;
}
// Hidden problem. Now the firstName instance variable is never set.
public void setFirstName(String firstName) {
  firstName = firstName;
}

//BUG4
HashSet currentMessages = new HashSet();
while (moreMessages()){
  Message message = getNextMessage();
  currentMessages.add(message.getID(), message);
  //do work with message
}

//BUG5
public class NonConcurrentServlet extends HttpServlet
{
  String name;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    userName = request.getParameter("name");
    out.println("<html><body>");
    out.println("<h1>Hello, "+name+"</h1>");
    out.println("</body></html>");
  }
}

//BUG6
FileSystemXmlApplicationContext context =
new FileSystemXmlApplicationContext("spring-beans.xml");
// is the salescontacts bean really going to be a ContactList??
ContactList list = (ContactList) context.getBean("salescontacts");
