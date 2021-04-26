package com.storageroom.security.controller;

import com.storageroom.StorageRoomApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StorageRoomApplication.class)
public class SecurityTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(value = "user", roles = {"USER"})
    public void testUserPanelWithUserRole() throws Exception {
        mockMvc
                .perform(
                        post("/user")
                                .contentType(
                                        MediaType.APPLICATION_JSON).
                                content("")).
                andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    @WithMockUser(value = "user", roles = {"USER"})
    public void testAdminPanelWithUserRole() throws Exception {
        mockMvc
                .perform(
                        post("/admin")
                                .contentType(
                                        MediaType.APPLICATION_JSON).
                                content("")).
                andExpect(status().isForbidden())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    @WithMockUser(value = "admin", roles = {"ADMIN"})
    public void testAdminPanelWithAdminRole() throws Exception {
        mockMvc
                .perform(
                        post("/admin")
                                .contentType(
                                        MediaType.APPLICATION_JSON).
                                content("")).
                andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}