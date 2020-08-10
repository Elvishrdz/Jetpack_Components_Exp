/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("Constants")

package com.eahm.jetpackcomponentsexp.utils

// Notification Channel constants

// Name of Notification Channel for verbose notifications of background work
@JvmField
val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence = "Verbose WorkManager Notifications"

const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION = "Shows notifications whenever work starts"
const val CHANNEL_ID = "VERBOSE_NOTIFICATION"
const val NOTIFICATION_ID = 1

// Other keys
const val KEY_BASIC_WORKER_DURATION = "KEY_BASIC_WORKER_DURATION"

// tags
const val TAG = "Utils"


