/*
 * MIT License
 *
 * Copyright (c) 2017 Pim van den Berg
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package test.nl.pvdberg.pnet.server.util;

import main.nl.pvdberg.pnet.server.Server;
import main.nl.pvdberg.pnet.server.util.PlainServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlainServerTest
{
    private static final int port1 = 123;
    private static final int port2 = 124;

    private Server server1;
    private Server server2;

    @Before
    public void setUp() throws Exception
    {
        server1 = new PlainServer();
        assertTrue(server1.start(port1));
        server2 = new PlainServer();
    }

    @After
    public void tearDown() throws Exception
    {
        server1.stop();
        server2.stop();
    }

    @Test
    public void illegalStart() throws Exception
    {
        assertFalse(server2.start(port1));
    }

    @Test
    public void start() throws Exception
    {
        assertTrue(server2.start(port2));
    }
}